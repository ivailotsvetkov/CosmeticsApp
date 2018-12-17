package com.example.asus.cosmeticsapp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "brand",
        "name",
        "price",
        "price_sign",
        "currency",
        "image_link",
        "product_link",
        "website_link",
        "description",
        "rating",
        "category",
        "product_type",
        "tag_list",
        "created_at",
        "updated_at",
        "product_api_url",
        "api_featured_image",
        "product_colors"
})
public class Cosmetic implements Serializable{
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private String price;
    @JsonProperty("price_sign")
    private Object priceSign;
    @JsonProperty("currency")
    private Object currency;
    @JsonProperty("image_link")
    private String imageLink;
    @JsonProperty("product_link")
    private String productLink;
    @JsonProperty("website_link")
    private String websiteLink;
    @JsonProperty("description")
    private String description;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("category")
    private Object category;
    @JsonProperty("product_type")
    private String productType;
    @JsonProperty("tag_list")
    private List<Object> tagList = null;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("product_api_url")
    private String productApiUrl;
    @JsonProperty("api_featured_image")
    private String apiFeaturedImage;
    @JsonProperty("product_colors")
    private List<Object> productColors = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("price_sign")
    public Object getPriceSign() {
        return priceSign;
    }

    @JsonProperty("price_sign")
    public void setPriceSign(Object priceSign) {
        this.priceSign = priceSign;
    }

    @JsonProperty("currency")
    public Object getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(Object currency) {
        this.currency = currency;
    }

    @JsonProperty("image_link")
    public String getImageLink() {
        return imageLink;
    }

    @JsonProperty("image_link")
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @JsonProperty("product_link")
    public String getProductLink() {
        return productLink;
    }

    @JsonProperty("product_link")
    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    @JsonProperty("website_link")
    public String getWebsiteLink() {
        return websiteLink;
    }

    @JsonProperty("website_link")
    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @JsonProperty("category")
    public Object getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Object category) {
        this.category = category;
    }

    @JsonProperty("product_type")
    public String getProductType() {
        return productType;
    }

    @JsonProperty("product_type")
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @JsonProperty("tag_list")
    public List<Object> getTagList() {
        return tagList;
    }

    @JsonProperty("tag_list")
    public void setTagList(List<Object> tagList) {
        this.tagList = tagList;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("product_api_url")
    public String getProductApiUrl() {
        return productApiUrl;
    }

    @JsonProperty("product_api_url")
    public void setProductApiUrl(String productApiUrl) {
        this.productApiUrl = productApiUrl;
    }

    @JsonProperty("api_featured_image")
    public String getApiFeaturedImage() {
        return apiFeaturedImage;
    }

    @JsonProperty("api_featured_image")
    public void setApiFeaturedImage(String apiFeaturedImage) {
        this.apiFeaturedImage = apiFeaturedImage;
    }

    @JsonProperty("product_colors")
    public List<Object> getProductColors() {
        return productColors;
    }

    @JsonProperty("product_colors")
    public void setProductColors(List<Object> productColors) {
        this.productColors = productColors;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}