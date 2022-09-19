package ass2.Models;
import java.beans.PropertyChangeListener;

public interface SafeModel{
	public static final String DISTANCE = "distance";
	public static final String DURATION = "duration";
	public static final String EXHALATIONLEVEL = "exhalationLevel";
	public static final String SAFE = "safe";
	int getDistance();
	int getDuration();
	int getExhalationLevel();
	boolean isSafe();
	void setValues(int distance, int duration, int exhalation);
	void addPropertyChangeListener(PropertyChangeListener aListener);
}
