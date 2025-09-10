package com.workintech.developers;

public class HRManager extends Employee {
    private JuniorDeveloper[] juniorDevelopers;
    private MidDeveloper[] midDevelopers;
    private SeniorDeveloper[] seniorDevelopers;

    public HRManager(long id, String name, double salary,
                     int juniorCap, int midCap, int seniorCap) {
        super(id, name, salary);
        this.juniorDevelopers = new JuniorDeveloper[Math.max(0, juniorCap)];
        this.midDevelopers = new MidDeveloper[Math.max(0, midCap)];
        this.seniorDevelopers = new SeniorDeveloper[Math.max(0, seniorCap)];
    }

    @Override public void work() {
        setSalary(getSalary() * 1.03);
        System.out.println("HR Manager is recruiting and organizing. Salary updated to " + getSalary());
    }

    // Overloads
    public boolean addEmployee(JuniorDeveloper d) { return addFirstEmpty(juniorDevelopers, d); }
    public boolean addEmployee(JuniorDeveloper d, int i) { return addAt(juniorDevelopers, d, i); }
    public boolean addEmployee(MidDeveloper d) { return addFirstEmpty(midDevelopers, d); }
    public boolean addEmployee(MidDeveloper d, int i) { return addAt(midDevelopers, d, i); }
    public boolean addEmployee(SeniorDeveloper d) { return addFirstEmpty(seniorDevelopers, d); }
    public boolean addEmployee(SeniorDeveloper d, int i) { return addAt(seniorDevelopers, d, i); }

    private <T> boolean addFirstEmpty(T[] arr, T item) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == null) { arr[i] = item; return true; }
        System.out.println("Uyarı: Uygun boş yer yok, eleman eklenemedi.");
        return false;
    }
    private <T> boolean addAt(T[] arr, T item, int index) {
        if (index < 0 || index >= arr.length) { System.out.println("Uyarı: Geçersiz index."); return false; }
        if (arr[index] != null) { System.out.println("Uyarı: Bu index dolu, ezilmedi."); return false; }
        arr[index] = item; return true;
    }
}