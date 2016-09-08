import ch17.TodoBuilderWithSupport

builder = new TodoBuilderWithSupport()

builder.build {
    Prepare_Vacation (start: '02/15', end: '02/22') {
        Reserve_Flight (on: '01/01', status: 'done')
        Reserve_Hotel (on: '01/02')
        Reserve_Car (on: '01/02')
    }

    Buy_New_Mac {
        Install_QuickSilver
        Install_TextMate
        Install_Groovy {
            Runn_all_tests
        }
    }
}