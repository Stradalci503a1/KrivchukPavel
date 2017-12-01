import org.junit.Assert;
import org.junit.Test;

public class FormatterTests {

    @Test
    public void nullString(){
        check(null, null);
    }

    @Test
    public void notEnoughArguments(){
        check("{0}  gsdg {1}",null, 34);
    }

    @Test
    public void classArgument(){
        TestTask testTask = new TestTask(5, 7);
        check("dsgsd {0} sdgsd", "dsgsd A: 5 B: 7 sdgsd", testTask);
    }
    @Test
    public void incorrectFiller() {
        check("342 {a} rwq {}", "342 {a} rwq {}");
    }

    @Test
    public void moreArgumentsThanNeeded() {
        check("fsefs {0} gsg", "fsefs 15 gsg", 15, 463, "rrew");
    }

    @Test
    public void skippedArgument() {
        check("ge{0} {2}", "ge54 g", 54, 21, "g");
    }

    @Test
    public void reverseArguments(){
        check("hbdf {1} gsd gs {0} gsd", "hbdf Arg2 gsd gs Arg1 gsd", "Arg1", "Arg2");
    }
    
    @Test
    public void correct(){
        check("Hello {0}, I am {1} years old","Hello hell, I am 15 years old", "hell", 15);
    }
    
    private void check(String input, String output, Object... arguments){
        Assert.assertEquals(Formatter.build(input, arguments), output);
    }
    
    private class TestTask{
        private int a;
        private int b;
        
        public TestTask(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        @Override
        public String toString(){
            return "A: " + a + " B: " + b;
        }
    }
}
