package cz.zcu.kiv.vo;

public class Identifier extends CallParameter {

    private final String identifier;

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Identifier id) {
            return this.identifier.equals(id.getIdentifier());
        }
        return false;
    }
}
