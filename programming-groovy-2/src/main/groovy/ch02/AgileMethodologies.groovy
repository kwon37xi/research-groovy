package ch02

enum Methodologies {
    Evo(5),
    XP(21),
    Scrum(30);

    final int daysInIteration

    Methodologies(days) {
        daysInIteration = days
    }

    def iterationDetails() {
        println "${this} recommends $daysInIteration days for iteration"
    }
}

for (methodology in Methodologies.values()) {
    methodology.iterationDetails()
}