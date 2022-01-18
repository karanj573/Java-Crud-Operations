import java.util.*;


class Student{
    private int studno;
    private String name;
    private int dot;

    Student(int studno, String name, int dot){
        this.studno = studno;
        this.name   = name;
        this.dot    = dot;
    }

    public int getStudno(){
        return studno;
    }
    public int getDot(){
        return dot;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return studno+" "+name+" "+dot;
    }
}

class CrudDemo{
    public static void main(String[] args) {
        
        List<Student>  C = new ArrayList<Student>();
         try (Scanner s = new Scanner(System.in)) {
            try (Scanner s1 = new Scanner(System.in)) {
                int ch;
                do{
                   System.out.println("1.INSERT");
                   System.out.println("2.DISPLAY");
                   System.out.println("3.SEARCH");
                   System.out.println("4.DELETE");
                   System.out.println("5.UPDATE");
                   System.out.println("Enter your choice : ");
                   ch = s.nextInt();

                   switch(ch){
                       case 1:
                            System.out.print("Enter Student no:");
                            int studno  = s.nextInt();
                            System.out.print("Enter Student Name :");
                            String name = s1.nextLine();
                            System.out.print("Enter Student Date of Birth:");
                            int dot     = s.nextInt();
                            C.add(new Student(studno, name, dot));
                       break;
                       case 2:
                            System.out.println("---------------------");
                            Iterator<Student> i = C.iterator();
                            while(i.hasNext()){
                                Student s2 = i.next();
                                System.out.println(s2);
                            }
                            System.out.println("---------------------");
                       break;
                       case 3:
                       boolean found = false;
                       System.out.print("Enter Studentno to Search : ");
                       studno = s.nextInt();
                       System.out.println("---------------------");
                       i = C.iterator();
                       while(i.hasNext()){
                           Student s2 = i.next();
                           if(s2.getStudno() == studno){
                               System.out.println(s2);
                               found = true;
                           }
                       }
                       System.out.println("---------------------");
                       if(!found){
                           System.out.println("Record Not Found");
                       }
                       System.out.println("---------------------");
                  break;
                  case 4:
                  found = false;
                  System.out.print("Enter Studentno to Delete : ");
                  studno = s.nextInt();
                  System.out.println("---------------------");
                  i = C.iterator();
                  while(i.hasNext()){
                      Student s2 = i.next();
                      if(s2.getStudno() == studno){
                          i.remove();
                          found = true;
                      }
                  }
                  System.out.println("---------------------");
                  if(!found){
                      System.out.println("Record Not Found");
                  }else{
                    System.out.println("Record is Deleted SuccessFully");

                  }
                  System.out.println("---------------------");
             break;
             case 5:
             found = false;
             System.out.print("Enter Studentno to Update : ");
             studno = s.nextInt();
             System.out.println("---------------------");
             ListIterator<Student> li = C.listIterator(); 
             while(li.hasNext()){
                 Student s2 = li.next();
                 if(s2.getStudno() == studno){
                     System.out.println("Enter new Name :");
                     name = s1.nextLine();
                     System.out.println("Enter new Date of Birth :");
                     dot = s.nextInt();
                     li.set(new Student(studno, name, dot));
                     found = true;
                 }
             }
             System.out.println("---------------------");
             if(!found){
                 System.out.println("Record Not Found");
             }else{
               System.out.println("Record is Updated SuccessFully");

             }
             System.out.println("---------------------");
        break;

                        
                   }
                }while(ch!=0);
            }
        }
        
    }
}