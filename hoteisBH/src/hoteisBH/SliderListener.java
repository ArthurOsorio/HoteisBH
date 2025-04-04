package hoteisBH;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {
	private CriaReservaTela frame;
	public SliderListener(CriaReservaTela frame) {
		this.frame=frame;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int value = frame.slider.getValue();
		frame.lblJslider.setText(Integer.toString(value));
	
	}

}
