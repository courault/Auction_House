package ah;

public interface Observable {

    /**
     * Notify observers of a new bid
     */
    public void notifyObserver();

    /**
     *
     * @param o : Observer's instance
     */
    public void subscribe(Observer o);

    public void unsubscribe(Observer o);
}
