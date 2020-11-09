import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Timesheet {

    private static volatile LocalTime activity = LocalTime.now();

    private static final Object LOCK = new Object();

    public static void main(String[] args) {

	GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);

	System.out.println("Global keyboard hook successfully started.");

	keyboardHook.addKeyListener(new GlobalKeyAdapter() {
	    @Override
	    public void keyPressed(GlobalKeyEvent event) {
		synchronized (LOCK) {
		    activity = LocalTime.now();
		}
	    }

	    @Override
	    public void keyReleased(GlobalKeyEvent event) {
		synchronized (LOCK) {
		    activity = LocalTime.now();
		}
	    }
	});

	GlobalMouseHook mouseHook = new GlobalMouseHook();

	System.out.println("Global mouse hook successfully started.");

	mouseHook.addMouseListener(new GlobalMouseAdapter() {

	    @Override
	    public void mousePressed(GlobalMouseEvent event) {
		synchronized (LOCK) {
		    activity = LocalTime.now();
		}
	    }

	    @Override
	    public void mouseReleased(GlobalMouseEvent event) {
		synchronized (LOCK) {
		    activity = LocalTime.now();
		}
	    }

	    @Override
	    public void mouseMoved(GlobalMouseEvent event) {
		synchronized (LOCK) {
		    activity = LocalTime.now();
		}
	    }

	    @Override
	    public void mouseWheel(GlobalMouseEvent event) {
		synchronized (LOCK) {
		    activity = LocalTime.now();
		}
	    }
	});

	Timer time = new Timer();
	time.schedule(new TimerTask() {
	    boolean afk = false;

	    @Override
	    public void run() {
		synchronized (LOCK) {
		    if (MINUTES.between(activity, LocalTime.now()) > 2 && !afk) {
			System.err.println("You are afk since " + activity);
			afk = true;
		    } else {
			afk = false;
		    }
		}
	    }
	}, 0, 10000);
    }
}
