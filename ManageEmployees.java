// Creates lists of employees in a company, grouping them by category.
// Then creates a list of all employees from the aforementioned lists.
// Also creates a list of rather arbitrary objects.
// Prints these lists out.
// Demonstrates the use of wildcards in Java.
//Seth Sutton
//Description:
//This Program implements methods using wildcard to display a list of employees in groups such as Web devs, Sys devs, Designers, Theorist, and General devs.
//Also displays there names along with what programming lanuage they perfer.

import java.util.ArrayList;

public class ManageEmployees {  	
  public static void main(String[] args) {
	ArrayList<WebDeveloper> webDevs = new ArrayList<>();
	webDevs.add(new WebDeveloper("Sir Timothy Berners-Lee"));
	webDevs.add(new WebDeveloper("Brendan Eich"));
	ArrayList<SystemsProgrammer> sysDevs = new ArrayList<>();
	sysDevs.add(new SystemsProgrammer("Grace Hopper"));
	sysDevs.add(new SystemsProgrammer("Donald Knuth"));
	ArrayList<Designer> designers = new ArrayList<>();
	designers.add(new Designer("Roberta Williams"));
	designers.add(new Designer("Sid Meier"));
	ArrayList<Theorist> theorists = new ArrayList<>();
	theorists.add(new Theorist("Shafrira Goldwasser"));
	theorists.add(new Theorist("Stephen Cook"));
	ArrayList<Programmer> devs = new ArrayList<>();
	devs.add(new Programmer("Richard Stallman"));
	devs.add(new Programmer("Bill Joy"));
	ArrayList<Object> objects = new ArrayList<>();
	objects.add(42);
	objects.add("Hello");
	objects.add(new Programmer("Linda Liukas"));
	
	System.out.println("Web devs: "); printNames(webDevs);
	System.out.println("Sys devs: "); printNames(sysDevs);
	System.out.println("Designers: "); printNames(designers);
	System.out.println("Theorists: "); printNames(theorists);
	System.out.println("General devs: "); printNames(devs);
	
	ArrayList<Employee> employees = new ArrayList<>();
	addElements(webDevs, employees);
	addElements(sysDevs, employees);
	addElements(designers, employees);
	addElements(theorists, employees);
	addElements(devs, employees);
	
	System.out.println("All employees: "); printNames(employees);
	
	System.out.println("Web devs (using toString):"); printAll(webDevs);
	System.out.println("Objects (using toString):"); printAll(objects);

	System.out.println("Among web developers: ");
	printFavoriteLanguages(webDevs);
	
	addElements(webDevs, devs);
	addElements(sysDevs, devs);
	
	System.out.println("Among all developers: ");
	printFavoriteLanguages(devs);
  }
   public static void printNames(ArrayList<? extends Employee> emp)
    {
        for (Employee e:emp
             ) {
            System.out.println(e.name());
        }
    }
    public static <E> void addElements(ArrayList<E> emp, ArrayList<? super E> emps)
    {
        for (E e:emp
             ) {
            emps.add(e);
        }
    }
    public static void printAll(ArrayList<? > employees)
    {
        for (Object e:employees
             ) {
            System.out.println(e);
        }
    }
    public static <E extends Programmer>void printFavoriteLanguages(ArrayList<E> emp)
    {
        for (E e:emp
                ) {
            System.out.println(e.name() + " prefers "+e.favoriteLanguage());
        }
    }
}

class Employee {
  private String name;
  public Employee (String name) {
	this.name = name;
  }
  public String name() {
	  return name;
  }
}

class Programmer extends Employee {
  public Programmer(String name) {
	super(name);
  }
  public String favoriteLanguage() {
	return "Java";
  }
}

class WebDeveloper extends Programmer {
  public WebDeveloper(String name) {
	super(name);
  }
  public String favoriteLanguage() {
	return "JavaScript";
  }
}

class SystemsProgrammer extends Programmer {
  public SystemsProgrammer(String name) {
    super(name);
  }
  public String favoriteLanguage() {
	return "C";
  }  
}

class Theorist extends Employee {
  public Theorist(String name) {
    super(name);
  }
}

class Designer extends Employee {
  public Designer(String name) {
	super(name);
  }
}

