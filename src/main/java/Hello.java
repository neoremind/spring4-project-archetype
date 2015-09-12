import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @author zhangxu
 */
public class Hello {

    public static void main(String[] args) {
        Result result = FluentValidator.checkAll()
                .on("abc", new StringValidator())
                .doValidate()
                .result(toSimple());
        System.out.println(result);
    }

}

class StringValidator extends ValidatorHandler<String> implements Validator<String> {

    @Override
    public boolean accept(ValidatorContext context, String s) {
        System.out.println("accept " + s);
        return true;
    }

    @Override
    public boolean validate(ValidatorContext context, String t) {
        String myname = context.getAttribute("myname", String.class);
        if (myname != null && myname.equals("pass")) {
            return true;
        }
        System.out.println("check " + t);
        if (!t.startsWith("abc")) {
            context.addError(ValidationError.create("string should be abc").setErrorCode(100).setField("str")
                    .setInvalidValue(t));
            return false;
        }
        return true;
    }

}


