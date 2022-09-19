package ass2.Models;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractModel implements SafeModel{
	protected Integer distance;
	protected Integer duration;
	protected Integer exhalation;
	protected Boolean safe;
	PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public AbstractModel() {
		distance = null;
		duration = null;
		exhalation = null;
		safe = null;
	}
	
	@Override
	public int getDistance() {
		return distance;
	}
	
	@Override
	public int getDuration() {
		return duration;
	}
	
	@Override
	public int getExhalationLevel() {
		return exhalation;
	}
	
	@Override
	public void setValues(int aDistance, int aDuration, int aExhalation) {
		Integer preDistance = this.distance;
		Integer preDuration = this.duration;
		Integer preExhalation = this.exhalation;
		Boolean preSafe = this.safe;
		this.distance = Integer.valueOf(aDistance);
		this.duration = Integer.valueOf(aDuration);
		this.exhalation = Integer.valueOf(aExhalation);
		this.safe = Boolean.valueOf(isSafe());
		propertyChangeSupport.firePropertyChange(DISTANCE, (Integer)preDistance, (Integer)distance);
		propertyChangeSupport.firePropertyChange(DURATION, (Integer)preDuration, (Integer)duration);
		propertyChangeSupport.firePropertyChange(EXHALATIONLEVEL, (Integer)preExhalation, (Integer)exhalation);
		propertyChangeSupport.firePropertyChange(SAFE, preSafe, safe);
		resetValues();
	}
	
	private void resetValues() {
		distance = null;
		duration = null;
		exhalation = null;
		safe = null;
	}
	
	@Override
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
	}
}
