package co.com.bancolombia._microservice.resolveEnigmaApi.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetEngimaRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-17T16:23:36.474-05:00[America/Bogota]")
public class GetEngimaRequest   {
  @JsonProperty("header")
  private Header header = null;

  @JsonProperty("enigma")
  private String enigma = null;

  public GetEngimaRequest header(Header header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
  public Header getHeader() {
    return header;
  }

  public void setHeader(Header header) {
    this.header = header;
  }

  public GetEngimaRequest enigma(String enigma) {
    this.enigma = enigma;
    return this;
  }

  /**
   * Get enigma
   * @return enigma
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getEnigma() {
    return enigma;
  }

  public void setEnigma(String enigma) {
    this.enigma = enigma;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetEngimaRequest getEngimaRequest = (GetEngimaRequest) o;
    return Objects.equals(this.header, getEngimaRequest.header) &&
        Objects.equals(this.enigma, getEngimaRequest.enigma);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, enigma);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetEngimaRequest {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    enigma: ").append(toIndentedString(enigma)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
