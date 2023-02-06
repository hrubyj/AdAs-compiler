package cz.zcu.kiv.vo;

import cz.zcu.kiv.gen.AdAsParser;

import java.util.ArrayList;
import java.util.List;

public class Parameters extends Expression {

    private final List<Parameter> parameterList = new ArrayList<>();
    private int parametersSize = 0;

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public void addParameter(Parameter parameter) {
        if (exists(parameter.getIdentifier().getIdentifier())) {
            System.out.println("Error: Parameter " + parameter.getIdentifier().getIdentifier() + " already exists");
            System.exit(0);
        } else {
            parameterList.add(parameter);
            parametersSize += parameter.getSize();
        }
    }

    private boolean exists(String value) {
        for (Parameter parameter : parameterList) {
            String paramName = parameter.getIdentifier().getIdentifier();
            if (paramName.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int getParametersSize() {
        return parametersSize;
    }
}
