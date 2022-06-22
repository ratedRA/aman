package com;

public class FavImportFilter extends DataImportFilter {

    private String cursor;

    private boolean cursorEnabled;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public boolean isCursorEnabled() {
        return cursorEnabled;
    }

    public void setCursorEnabled(boolean cursorEnabled) {
        this.cursorEnabled = cursorEnabled;
    }

    @Override
    public String toString() {
        return super.toString() + toCurrString();
    }

    public String toCurrString() {
        return "FavImportFilter{" +
                "cursor='" + cursor + '\'' +
                ", cursorEnabled=" + cursorEnabled +
                '}';
    }
}
