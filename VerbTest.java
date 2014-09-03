
class VerbTest {
    
    public static void main(String[] args) throws java.io.IOException {

        System.out.println("VerbTest started.");
        VerbTool vt = new VerbTool();    
        System.out.println("VerbTool created.");
        System.out.println(vt.verb_infinitive("went"));
        System.out.println("checkAgreement:");
        System.out.println(vt.checkAgreement("He","go"));
        System.out.println(vt.checkAgreement("He","goes"));
    
    }

}
