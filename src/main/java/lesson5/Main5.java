package lesson5;

public class Main5 {

    public static void main(String[] args) {

        StudentRepo<Student> studentStudentRepo = new StudentRepo<>(Student.class);
        studentStudentRepo.applyScript();
        studentStudentRepo.create(new Student("souer", 15));
        for (int i = 0; i < 100; i++) {
            studentStudentRepo.create(new Student("" + i, i));
        }
        studentStudentRepo.readAll();
        studentStudentRepo.delete("souer");
        studentStudentRepo.readAll();
        studentStudentRepo.shutdown();

    }

}
