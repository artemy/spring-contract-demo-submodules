package contracts

import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    request {
        method = GET
        url = url("/foo")
        headers {
            accept = APPLICATION_JSON
        }
    }
    response {
        status = OK
        headers {
            contentType = APPLICATION_JSON
        }
        body = body(
            "foo" to value(consumer("FOO"), producer(optional(anyOf("FOO", "BAR")))),
            "bar" to value(consumer("FOO"), producer(optional(anyNonBlankString))),
            "baz" to value(consumer("BAZ"), producer(optional(nonBlank)))
        )
    }
}
