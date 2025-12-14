import java.util.Scanner;

public class Policy {

    private int policyNumber;
    private String providerName;
    private String policyHolderFirstName;   
    private String policyHolderLastName;    
    private int policyHolderAge;            
    private String policyHolderSmokingStatus; 
    private double policyHolderHeight;      
    private double policyHolderWeight;      

    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyHolderFirstName = "";
        policyHolderLastName = "";
        policyHolderAge = 0;
        policyHolderSmokingStatus = "non-smoker";
        policyHolderHeight = 0.0;
        policyHolderWeight = 0.0;
    }


    public Policy(int pNum, String pProvider, String pHolderFirst, String pHolderLast, 
                  int pAge, String pSmoke, double pHeight, double pWeight) {
        policyNumber = pNum;
        providerName = pProvider;
        policyHolderFirstName = pHolderFirst;
        policyHolderLastName = pHolderLast;
        policyHolderAge = pAge;
        policyHolderSmokingStatus = pSmoke;
        policyHolderHeight = pHeight;
        policyHolderWeight = pWeight;
    }


    public void setPolicyNumber(int pNum) {
        policyNumber = pNum;
    }

    public void setProviderName(String pProvider) {
        providerName = pProvider;
    }

    public void setPolicyHolderFirstName(String pHolderFirst) {
        policyHolderFirstName = pHolderFirst;
    }

    public void setPolicyHolderLastName(String pHolderLast) {
        policyHolderLastName = pHolderLast;
    }

    public void setPolicyHolderAge(int pAge) {
        policyHolderAge = pAge;
    }

    public void setPolicyHolderSmokingStatus(String pSmoke) {
        policyHolderSmokingStatus = pSmoke;
    }

    public void setPolicyHolderHeight(double pHeight) {
        policyHolderHeight = pHeight;
    }

    public void setPolicyHolderWeight(double pWeight) {
        policyHolderWeight = pWeight;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getPolicyHolderFirstName() {
        return policyHolderFirstName;
    }

    public String getPolicyHolderLastName() {
        return policyHolderLastName;
    }

    public int getPolicyHolderAge() {
        return policyHolderAge;
    }

    public String getPolicyHolderSmokingStatus() {
        return policyHolderSmokingStatus;
    }

    public double getPolicyHolderHeight() {
        return policyHolderHeight;
    }

    public double getPolicyHolderWeight() {
        return policyHolderWeight;
    }


    
    public double calculateBMI() {
        if (policyHolderHeight == 0) {
            return 0;
        }
        return (policyHolderWeight * 703) / (policyHolderHeight * policyHolderHeight);
    }

    public double calculatePrice() {
        double price = 600.0; 

        if (policyHolderAge > 50) {
            price += 75.0;
        }

        if (policyHolderSmokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            double additionalFee = (bmi - 35) * 20;
            price += additionalFee;
        }

        return price;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputPolicyNum, inputAge;
        String inputProvider, inputFirst, inputLast, inputSmoke;
        double inputHeight, inputWeight;

        System.out.print("Please enter the Policy Number: ");
        inputPolicyNum = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Please enter the Provider Name: ");
        inputProvider = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        inputFirst = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        inputLast = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        inputAge = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        inputSmoke = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        inputHeight = scanner.nextDouble();

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        inputWeight = scanner.nextDouble();


        Policy policy = new Policy(inputPolicyNum, inputProvider, inputFirst, inputLast, 
                                   inputAge, inputSmoke, inputHeight, inputWeight);

        System.out.println(); 
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getPolicyHolderFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getPolicyHolderLastName());
        System.out.println("Policyholder’s Age: " + policy.getPolicyHolderAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getPolicyHolderSmokingStatus());
        System.out.printf("Policyholder’s Height: %.1f inches\n", policy.getPolicyHolderHeight());
        System.out.printf("Policyholder’s Weight: %.1f pounds\n", policy.getPolicyHolderWeight());
        System.out.printf("Policyholder’s BMI: %.2f\n", policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f\n", policy.calculatePrice());
    }
}