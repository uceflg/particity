
package de.particity.schemagen.impexpv100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImportExportRoot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImportExportRoot"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Organisation" type="{http://github.com/fraunhoferfokus/particity/ImportExport}OrganisationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Offer" type="{http://github.com/fraunhoferfokus/particity/ImportExport}OfferType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Category" type="{http://github.com/fraunhoferfokus/particity/ImportExport}CategoryType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Subscription" type="{http://github.com/fraunhoferfokus/particity/ImportExport}SubscriptionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Config" type="{http://github.com/fraunhoferfokus/particity/ImportExport}ConfigurationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImportExportRoot", propOrder = {
    "organisation",
    "offer",
    "category",
    "subscription",
    "config"
})
@XmlRootElement(name = "ImportExportRoot")
public class ImportExportRoot {

    @XmlElement(name = "Organisation")
    protected List<OrganisationType> organisation;
    @XmlElement(name = "Offer")
    protected List<OfferType> offer;
    @XmlElement(name = "Category")
    protected List<CategoryType> category;
    @XmlElement(name = "Subscription")
    protected List<SubscriptionType> subscription;
    @XmlElement(name = "Config")
    protected List<ConfigurationType> config;
    @XmlAttribute(name = "Version")
    protected String version;

    /**
     * Gets the value of the organisation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organisation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganisation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganisationType }
     * 
     * 
     */
    public List<OrganisationType> getOrganisation() {
        if (organisation == null) {
            organisation = new ArrayList<OrganisationType>();
        }
        return this.organisation;
    }

    /**
     * Gets the value of the offer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OfferType }
     * 
     * 
     */
    public List<OfferType> getOffer() {
        if (offer == null) {
            offer = new ArrayList<OfferType>();
        }
        return this.offer;
    }

    /**
     * Gets the value of the category property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoryType }
     * 
     * 
     */
    public List<CategoryType> getCategory() {
        if (category == null) {
            category = new ArrayList<CategoryType>();
        }
        return this.category;
    }

    /**
     * Gets the value of the subscription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subscription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubscription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubscriptionType }
     * 
     * 
     */
    public List<SubscriptionType> getSubscription() {
        if (subscription == null) {
            subscription = new ArrayList<SubscriptionType>();
        }
        return this.subscription;
    }

    /**
     * Gets the value of the config property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the config property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConfigurationType }
     * 
     * 
     */
    public List<ConfigurationType> getConfig() {
        if (config == null) {
            config = new ArrayList<ConfigurationType>();
        }
        return this.config;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
