#include <iostream>
#include <string>


public class Student{
    private:
        std::string name;
        int grade;

    public:
        void setGrade(int g)
        {
            this->grade = g;
        }


@Test
public void testStudent()
{
    Student s = new Student();
    s.setGrade(10);
    assertEquals(10, s.getGrade());
}

@Test
public void testStudentNegative()
{
    Student s = new Student();
    s.setGrade(10);
    s.setGrade(-3);
    assertEquals(10, s.getGrade());
}
}