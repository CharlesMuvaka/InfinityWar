package avengers;

import java.util.*;

public class EventsAdjacentList {
    private Event[] events;
    private int noOfEvents;

    public EventsAdjacentList(int noOfEvents) {
        this.noOfEvents = noOfEvents;
        this.events = new Event[noOfEvents];
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public void addNeighbor(Event event, Event neighbors) {
        for (int i = 0; i < events.length; i++) {
            if (events[i].getIndex() == event.getIndex()) {
                event.setNeighbors(neighbors);
            }
        }
    }

    public void printGraph() {
        for (int i = 0; i < events.length; i++) {
            StdOut.println(events[i].getIndex() + ": " + events[i].getNeighbors());
        }
    }

}