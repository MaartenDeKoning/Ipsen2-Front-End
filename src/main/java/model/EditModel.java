package model;

import observable.EditObservable;
import observer.EditObserver;

/**
 * EditModel.java is our model which stores information
 * @author  Jesse Minneboo
 * @version 1.0
 */

public class EditModel implements EditObservable {
    private String title;
    private String langauge;
    private String subject;
    private String fieldOfStudy;
    private String tags;
    private String category;
    private String pathForFile;

    public String getPathForFile() {
        return pathForFile;
    }

    public void saveAllElements(String title, String langauge, String subject, String fieldOfStudy, String tags, String category, String pathForFile){
        System.out.println("\nDit is opgeslagen:");
        setTitle(title);
        System.out.println("De titel is: " + title);
        setLangauge(langauge);
        System.out.println("De taal is: " +langauge);
        setSubject(subject);
        System.out.println("Het vak is: " +subject);
        setFieldOfStudy(fieldOfStudy);
        System.out.println("De richting is: " +fieldOfStudy);
        setTags(tags);
        System.out.println("De tags zijn: " +tags);
        setCategory(category);
        System.out.println("De catagorie is: " +category);
        setPathForFile(pathForFile);
        System.out.println("Het pad naar het bestand is: " +pathForFile + "\n");
    }

    public void addObserver(EditObserver observer) {}
    public void notifyObservers() {}
    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setLangauge(String langauge) {
        this.langauge = langauge;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPathForFile(String pathForFile) {
        this.pathForFile = pathForFile;
    }
}
