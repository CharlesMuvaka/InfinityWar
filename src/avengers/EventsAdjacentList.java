package avengers;

import java.util.*;

public class EventsAdjacentList {
    private Event[] events;
    private int noOfEvents;

    public EventsAdjacentList(int noOfEvents) {
        this.noOfEvents = noOfEvents;
        this.events = new Event[noOfEvents];
    }

}