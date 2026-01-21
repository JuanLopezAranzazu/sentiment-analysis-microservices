package org.juanlopezaranzazu;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class SentimentResourceTest {

    @Test
    void shouldReturnValidSentimentResponse() {

        given()
            .contentType("application/json")
            .body("""
                {
                  "text": "The product quality is acceptable"
                }
            """)
        .when()
            .post("/api/comments")
        .then()
            .statusCode(201)
            .body("$", hasKey("sentiment"))
            .body("$", hasKey("confidence"))

            .body("sentiment", anyOf(
                    equalTo("positive"),
                    equalTo("neutral"),
                    equalTo("negative")
            ))
            .body("confidence", allOf(
                    greaterThanOrEqualTo(0f),
                    lessThanOrEqualTo(1f)
            ));
    }
}
