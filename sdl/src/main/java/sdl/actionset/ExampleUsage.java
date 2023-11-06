package sdl.actionset;

import java.util.List;

/*
https://gist.github.com/flibitijibibo/aa8a61196621adf17f76d182720830c1#chapter-0-what-are-action-sets
 */
public class ExampleUsage {
    class Action {

    }

    class Output {

    }

    static class ActionSet {
        private final String internalName;
        private final List<Action> actions;
        private final List<Output> outputs;

        private ActionSet(String internalName, List<Action> actions, List<Output> outputs) {
            this.internalName = internalName;
            this.actions = actions;
            this.outputs = outputs;
        }

        public static ActionSet.Builder newBuilder() {
            return new ActionSet.Builder();
        }

        static class Builder {
            private String internalName;
            private List<Action> actions;
            private List<Output> outputs;

            public Builder internalName(String internalName) {
                this.internalName = internalName;
                return this;
            }

            public Builder actions(List<Action> actions) {
                this.actions = actions;
                return this;
            }

            public Builder outputs(List<Output> outputs) {
                this.outputs = outputs;
                return this;
            }

            public ActionSet build() {
                return new ActionSet(internalName, actions, outputs);
            }
        }
    }

    public static void main(String[] args) {
        var sets = List.of(
                ActionSet.newBuilder()
                        .internalName("Menus")
                        .actions(List.of())
                        .outputs(List.of())
                        .build()
        );
    }
}
