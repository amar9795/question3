import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

    public class Loan
    {
        private int loanId;
        private String loanType;
        private double loanAmount;
        private int tenure;
        private double roi;
        private double salary;
        private String dateOfPreviousInstallment;


        public  enum loanStatus{pending,approved,reject};
        private double emiPerMonth;
        private String loanDisbursalDate;
        private double maxEligibleLoanAmount;
        private int repaymentFrequency;
        public Loan() {

        }

        public int getLoanId() {
            return loanId;
        }

        public void setLoanId(int loanId) {
            this.loanId = loanId;
        }

        public String getLoanType() {
            return loanType;
        }

        public void setLoanType(String loanType) {
            this.loanType = loanType;
        }

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public int getTenure() {
            return tenure;
        }

        public void setTenure(int tenure) {
            this.tenure = tenure;
        }

        public double getRoi() {
            return roi;
        }

        public void setRoi(double roi) {
            this.roi = roi;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getDateOfPreviousInstallment() {
            return dateOfPreviousInstallment;
        }

        public void setDateOfPreviousInstallment(String dateOfPreviousInstallment) {
            this.dateOfPreviousInstallment = dateOfPreviousInstallment;
        }

        public String getLoanDisbursalDate() {
            return loanDisbursalDate;
        }

        public void setLoanDisbursalDate(String loanDisbursalDate) {
            this.loanDisbursalDate = loanDisbursalDate;
        }

        public int getRepaymentFrequency() {
            return repaymentFrequency;
        }

        public void setRepaymentFrequency(int repaymentFrequency) {
            this.repaymentFrequency = repaymentFrequency;
        }

        public void calculateEmi()
        {
            double finalRoi = roi*0.01;
            // System.out.println(finalRoi);
            double roiandNoOfPayment = finalRoi/repaymentFrequency;

            double n= tenure*repaymentFrequency;
            double power = Math.pow((1+roiandNoOfPayment),n);
            emiPerMonth = loanAmount*(finalRoi/repaymentFrequency) /(1-1/power);


        }
        public void generateRepaymentSchedule() {


            double finalroi = roi * 0.01;
            double roiandNoOfPayment = finalroi / repaymentFrequency;
            double n = tenure * repaymentFrequency;
            double power = Math.pow((1 + roiandNoOfPayment), n);
            emiPerMonth = loanAmount * (finalroi / repaymentFrequency) / (1 - 1 / power);
            System.out.println("Monthly Installment is:" + emiPerMonth);
            double openingBalance = loanAmount;
            double principalComponent = 0;
            double interestComponent = 0;
            double installment = emiPerMonth;
            for (int i = 0; i <= n; i++) {


                openingBalance = openingBalance - principalComponent;
                interestComponent = openingBalance * (finalroi / repaymentFrequency);
                principalComponent = installment - interestComponent;
                System.out.println("Installment No:" + "  " + i + "  " + "Opening Balance:" + "  " + openingBalance + "  " + "Principal Component:" + "  " + principalComponent + "  " + "IntersetComponent:" + "  " + interestComponent + "  " + "Inatallment:" + "  " + installment);

            }
        }
        public void calculateLatePenality()
        {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(getDateOfPreviousInstallment(), formatter);

            long diff = ChronoUnit.DAYS.between(date,today);
            double penalty = diff*50;
            System.out.println("Penalty is:" +penalty);
        }


        public void calculateEligibleLoanAmount()
        {
            double E = (salary*0.8)/2; //Max Eligible EMI
            double effectiveroi = roi*0.01;
            double power = Math.pow((1+effectiveroi),tenure);
            maxEligibleLoanAmount = (E*(power)-1)/effectiveroi*power;
            System.out.println("MaX Eligible Loan Amount:" + maxEligibleLoanAmount);
        }



    }

