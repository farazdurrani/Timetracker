import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;

public class Timesheet {

    public static void main(String[] args) {

	GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);

	System.out.println("Global keyboard hook successfully started.");

	keyboardHook.addKeyListener(new GlobalKeyAdapter() {

	    @Override
	    public void keyPressed(GlobalKeyEvent event) {

	    }

	    @Override
	    public void keyReleased(GlobalKeyEvent event) {

	    }
	});

	GlobalMouseHook mouseHook = new GlobalMouseHook();

	System.out.println("Global mouse hook successfully started.");

	mouseHook.addMouseListener(new GlobalMouseAdapter() {

	    @Override
	    public void mousePressed(GlobalMouseEvent event) {
		System.out.println(event);
	    }

	    @Override
	    public void mouseReleased(GlobalMouseEvent event) {
		System.out.println(event);
	    }

	    @Override
	    public void mouseMoved(GlobalMouseEvent event) {
		System.out.println(event);
	    }

	    @Override
	    public void mouseWheel(GlobalMouseEvent event) {
		System.out.println(event);
	    }
	});
    }
}
