public class HomeLoan extends SecuredLoan
    {
        private String buildername;
        private int propertySize;
        private double propertyValue;

        public String getBuildername() {
            return buildername;
        }

        public void setBuildername(String buildername) {
            this.buildername = buildername;
        }

        public int getPropertySize() {
            return propertySize;
        }

        public void setPropertySize(int propertySize) {
            this.propertySize = propertySize;
        }

        public double getPropertyValue() {
            return propertyValue;
        }

        public void setPropertyValue(double propertyValue) {
            this.propertyValue = propertyValue;
        }

        public void homeLoneLTV(){
            double LTV = getLoanAmount()/getPropertyValue();
            System.out.println("Home Lone LTV is:" + LTV);
            loanStatus l = new loanStatus();

        }



    }
