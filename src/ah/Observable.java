package ah;


public interface Observable {
   
    /**
     * Notify observers of a new bid
     */
    public void notifyObserver();
    
    /**
     * 
     * @param o : Observer's instance
     * @return Observer's ID for the observable
     */
    public void subscribe (Observer o);
    
}
