package main.java.model.management;

import main.java.model.models.Exam;
import main.java.model.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ExamList{
    private ArrayList<Exam> Exams;

    public ExamList(){
        Exams = new ArrayList<>();

        //TODO delete examId
        Exams.add(new Exam(1, 1 , "informatics", "1-2-2022"));
        Exams.add(new Exam(2, 2 , "Software", "2-2-2022"));
        Exams.add(new Exam(3, 3 , "Math", "3-2-2022"));
        Exams.add(new Exam(4, 4 , "Analysis", "4-2-2022"));
        Exams.add(new Exam(5, 5 , "AI", "5-2-2022"));

    }

    public void addExam(Exam exam){
        readFromFile();
        Exams.add(exam);
        saveToFile();
    }

    public ArrayList<Exam> getExams(){
        return Exams;
    }


    public  ArrayList<Exam> getExamByName(String name){
        readFromFile();
        return Exams.stream().filter(s -> s.getExamDesc().toLowerCase().equals(name.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Exam> getExamGradeBySubjectId(int id){
        readFromFile();
        return Exams.stream().filter(s -> s.getSubjectId() ==(id)).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<Exam> getExamGradeByDate(String date){
        readFromFile();
        return Exams.stream().filter(s -> s.getDate().toLowerCase().equals(date.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
    }



    public boolean saveToFile(){
        try {
            FileOutputStream zed = new FileOutputStream("src/main/java/datafile/Exams.txt");
            ObjectOutputStream zee = new ObjectOutputStream(zed);
            zee.writeObject(Exams);
            zee.close();
            return true;
        }
        catch (IOException e){
            System.out.println("file output error");
            return false;
        }
    }




    public ArrayList<Exam> readFromFile(){
        try {
            FileInputStream zed = new FileInputStream("src/main/java/datafile/Exams.txt");
            ObjectInputStream zee = new ObjectInputStream(zed);
            Exams = (ArrayList<Exam>) zee.readObject();
            zee.close();
            return Exams;
        }catch (IOException e){
            System.out.println("error with reading file");
            return null;
        }
        catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
            return null;
        }
    }


}
