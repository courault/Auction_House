package ah;


public interface Observable {
   
    public void notifyObserver();
    
    public int subscribe (Observer o);
    
}
