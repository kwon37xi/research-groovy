package ch13_ast_transformation.app

import ch13_ast_transformation.User
import groovy.transform.CompileStatic

// java.lang.IllegalAccessError: tried to access method ch13_ast_transformation.User.changeUsername(Ljava/lang/String;)V from class ch13_ast_transformation.app.App
// 에러가 발생해야함.
@CompileStatic
def changeUsername() {
    final User user = new User('mrhaki')
    user.changeUsername 'Hubert A. Klein Ikkink'
}

changeUsername()