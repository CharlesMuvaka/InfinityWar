package avengers;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private int index;
    private int weight;
    private List<Event> neighbors = new ArrayList<>();

    public Event(int index) {
        this.index = index;
//        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Event> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Event neighbors) {
        this.neighbors.add(neighbors);
    }
}
