import groovy.transform.TypeChecked

// @DelegateTo : 메소드용 어노테이션, 어떤 클래스가 메소드 코드 실행을 책임지는지 명시.
// @TypeChecked 혹은 @CompileStatic 사용시 compile time 에 체크.

class Reservation {
    private Date date
    private String event
    private String attendee

    void date(final Date date) { this.date = date }
    void event(final String event) { this.event = event }
    void attendee(final String attendee) { this.attendee = attendee }

    static void submit(@DelegatesTo(Reservation) final Closure config) {
        final Reservation reservation = new Reservation()
        reservation.with config
    }
}

@TypeChecked
class Event {
    void submitReservation() {
        Reservation.submit {
            date Date.parse('yyyyMMdd', '20130522')
            event 'Gr8Conf'
            attendee 'mrhaki'
            reserved true
        }
    }
}

final event = new Event()
event.submitReservation()

/*
 컴파일 에러 발생

org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:
/home/kwon37xi/IdeaProjects/research-groovy/groovy-goodness/scripts/15_dsl_and_builder/delegates_to.groovy: 28: [Static type checking] - Cannot find matching method Event#reserved(boolean). Please check if the declared type is right and if the method exists.
 @ line 28, column 13.
               reserved true
               ^

1 error
  */