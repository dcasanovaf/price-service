package com.casanova.price.adapter.in.rest.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * The type Price 400 response.
 */
@JsonTypeName("Price_400_response")
public class Price400Response {

  @JsonProperty("status")
  private JsonNullable<Object> status = JsonNullable.undefined();

  @JsonProperty("path")
  private JsonNullable<Object> path = JsonNullable.undefined();

  @JsonProperty("apiVersion")
  private String apiVersion;

  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("logRef")
  private String logRef;

  @JsonProperty("exception")
  private String exception;

  @JsonProperty("message")
  private String message;

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent()
      && Objects.deepEquals(
        a.get(),
        b.get()));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  /**
   * Status price 400 response.
   *
   * @param status the status
   * @return the price 400 response
   */
  public Price400Response status(Object status) {
    this.status = JsonNullable.of(status);
    return this;
  }

  /**
   * Gets status.
   *
   * @return the status
   */
  @Schema(name = "status", example = "400", required = false)
  public JsonNullable<Object> getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(JsonNullable<Object> status) {
    this.status = status;
  }

  /**
   * Path price 400 response.
   *
   * @param path the path
   * @return the price 400 response
   */
  public Price400Response path(Object path) {
    this.path = JsonNullable.of(path);
    return this;
  }

  /**
   * Gets path.
   *
   * @return the path
   */
  @Schema(name = "path", example = "/prices", required = false)
  public JsonNullable<Object> getPath() {
    return path;
  }

  /**
   * Sets path.
   *
   * @param path the path
   */
  public void setPath(JsonNullable<Object> path) {
    this.path = path;
  }

  /**
   * Api version price 400 response.
   *
   * @param apiVersion the api version
   * @return the price 400 response
   */
  public Price400Response apiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

  /**
   * Gets api version.
   *
   * @return the api version
   */
  @NotNull
  @Schema(name = "apiVersion", example = "1.0.0", description = "API version", required = true)
  public String getApiVersion() {
    return apiVersion;
  }

  /**
   * Sets api version.
   *
   * @param apiVersion the api version
   */
  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  /**
   * Timestamp price 400 response.
   *
   * @param timestamp the timestamp
   * @return the price 400 response
   */
  public Price400Response timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Gets timestamp.
   *
   * @return the timestamp
   */
  @NotNull
  @Schema(name = "timestamp",
          example = "2022-07-01T06:57:02.283+00:00",
          description = "Timestamp",
          required = true)
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Sets timestamp.
   *
   * @param timestamp the timestamp
   */
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Log ref price 400 response.
   *
   * @param logRef the log ref
   * @return the price 400 response
   */
  public Price400Response logRef(String logRef) {
    this.logRef = logRef;
    return this;
  }

  /**
   * Gets log ref.
   *
   * @return the log ref
   */
  @Schema(name = "logRef",
          example = "a6f00445-bcb7-4858-a493-34e982d9b65a",
          description = "Log reference",
          required = false)
  public String getLogRef() {
    return logRef;
  }

  /**
   * Sets log ref.
   *
   * @param logRef the log ref
   */
  public void setLogRef(String logRef) {
    this.logRef = logRef;
  }

  /**
   * Exception price 400 response.
   *
   * @param exception the exception
   * @return the price 400 response
   */
  public Price400Response exception(String exception) {
    this.exception = exception;
    return this;
  }

  /**
   * Gets exception.
   *
   * @return the exception
   */
  @NotNull
  @Schema(name = "exception",
          example = "RuntimeException",
          description = "Exception name",
          required = true)
  public String getException() {
    return exception;
  }

  /**
   * Sets exception.
   *
   * @param exception the exception
   */
  public void setException(String exception) {
    this.exception = exception;
  }

  /**
   * Message price 400 response.
   *
   * @param message the message
   * @return the price 400 response
   */
  public Price400Response message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  @NotNull
  @Schema(name = "message", description = "Error description", required = true)
  public String getMessage() {
    return message;
  }

  /**
   * Sets message.
   *
   * @param message the message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Price400Response price400Response = (Price400Response) o;
    return equalsNullable(this.status, price400Response.status)
      && equalsNullable(this.path, price400Response.path)
      && Objects.equals(this.apiVersion, price400Response.apiVersion)
      && Objects.equals(this.timestamp, price400Response.timestamp)
      && Objects.equals(this.logRef, price400Response.logRef)
      && Objects.equals(this.exception, price400Response.exception)
      && Objects.equals(this.message, price400Response.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(status),
        hashCodeNullable(path),
        apiVersion,
        timestamp,
        logRef,
        exception,
        message);
  }

  @Override
  public String toString() {
    String sb = "class Price400Response {\n"
                + "    status: " + toIndentedString(status) + "\n"
                + "    path: " + toIndentedString(path) + "\n"
                + "    apiVersion: " + toIndentedString(apiVersion) + "\n"
                + "    timestamp: " + toIndentedString(timestamp) + "\n"
                + "    logRef: " + toIndentedString(logRef) + "\n"
                + "    exception: " + toIndentedString(exception) + "\n"
                + "    message: " + toIndentedString(message) + "\n"
                + "}";
    return sb;
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

