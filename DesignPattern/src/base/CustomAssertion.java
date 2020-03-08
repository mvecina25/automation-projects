package base;

import java.util.List;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Lists;

public class CustomAssertion extends Assertion{
	
	private List<String> assert_messages = Lists.newArrayList();
	
	@Override
    public void onBeforeAssert(IAssert<?> assertCommand) {
      assert_messages.add("BeforeAssert:" + assertCommand.getMessage());
    }
    
    @Override
    public void onAfterAssert(IAssert<?> assertCommand) {
      assert_messages.add("AfterAssert:" + assertCommand.getMessage());
    }
    
    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
      assert_messages.add("OnlyOnAssertSuccess:" + assertCommand.getMessage());
    }
    
    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
      assert_messages.add("OnlyOnAssertFailure:" + assertCommand.getMessage());
        
    }
   
    public List<String> getAssertMessages() {
      return assert_messages;
    }

}
