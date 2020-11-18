package com.github.donmahallem.stargazer;

public class DataContainer {
    public final static int NUM_ITEMS=200;
    public final static ListItem[] ITEMS = new ListItem[NUM_ITEMS];
    static{
        for(int i=0;i<NUM_ITEMS;i++){
            DataContainer.ITEMS[i]=new ListItem(i,
                    new StringBuilder().append("Entry ").append(i).toString(),
                    new StringBuilder().append("Zufallszahl ").append(Math.random()).toString());
        }
    }
    /**
     * A dummy item representing a piece of content.
     */
    public static class ListItem {
        public final int id;
        public final String title;
        public final String details;

        public ListItem(int id, String title, String details) {
            this.id = id;
            this.title = title;
            this.details = details;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append(this.id)
                    .append(this.title)
                    .append(this.details)
                    .toString();
        }
    }
}
