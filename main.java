import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        HomeLoan hm = new HomeLoan();
        VehicleLoan Vm = new VehicleLoan();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Lone Type");
        hm.setLoanType(sc.nextLine());
        System.out.println("Enter Lone Amount");
        hm.setLoanAmount(sc.nextDouble());
        System.out.println("Enter Tenure");
        hm.setTenure(sc.nextInt());
        System.out.println("Enter rte of Interest");
        hm.setRoi(sc.nextDouble());
        System.out.println("Enter salary");
        hm.setSalary(sc.nextDouble());

        System.out.println("Enter Repayment frequency");
        hm.setRepaymentFrequency(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter date of previous installment");
        hm.setDateOfPreviousInstallment(sc.nextLine());
        System.out.println("Enter Builder Name");
        hm.setBuildername(sc.nextLine());
        System.out.println("Enter Property Size");
        hm.setPropertySize(sc.nextInt());
        System.out.println("Enter Property value");
        hm.setPropertyValue(sc.nextDouble());
        System.out.println("Enter Vehicle Category");
        Vm.setVehicleCategory(sc.nextLine());
        System.out.println("Enter Vehicle Model No.");
        Vm.setVehicleModelNo(sc.nextLine());
        System.out.println("Enter Manufacturer");
        Vm.setManufacturer(sc.nextLine());
        System.out.println("Enter Year of Manufacture");
        Vm.setYearOfmanufacture(sc.nextInt());
        System.out.println("Enter Asset value");
        Vm.setAssetValue(sc.nextDouble());
        sc.close();

        hm.calculateEligibleLoanAmount();
        hm.calculateEmi();
        hm.calculateLatePenality();
        hm.generateRepaymentSchedule();
        hm.calculateLoanToValueRatio();
        hm.homeLoneLTV();
        Vm.vehicleLoneLTV();

}}
