package mazzo;

public enum Seme {
    BLACKJACK {
        @Override
        public String toString() { return "J";}
    },
    CUORI{
        @Override
        public String toString() { return "C";}
    },
    QUADRI{
        @Override
        public String toString() { return "Q";}
    },
    FIORI{
        @Override
        public String toString() { return "F";}
    },
    PICCHE{
        @Override
        public String toString() { return "P";}
    }
}
