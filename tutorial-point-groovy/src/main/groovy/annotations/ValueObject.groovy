package annotations

import groovy.transform.AnnotationCollector
import groovy.transform.Immutable
import groovy.transform.ToString


@AnnotationCollector([ToString, Immutable])
@interface ValueObject {

}