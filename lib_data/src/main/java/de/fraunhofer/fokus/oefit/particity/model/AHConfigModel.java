package de.fraunhofer.fokus.oefit.particity.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the AHConfig service. Represents a row in the &quot;AHCFG&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHConfigModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.fraunhofer.fokus.oefit.particity.model.impl.AHConfigImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHConfig
 * @see de.fraunhofer.fokus.oefit.particity.model.impl.AHConfigImpl
 * @see de.fraunhofer.fokus.oefit.particity.model.impl.AHConfigModelImpl
 * @generated
 */
public interface AHConfigModel extends BaseModel<AHConfig> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a a h config model instance should use the {@link AHConfig} interface instead.
     */

    /**
     * Returns the primary key of this a h config.
     *
     * @return the primary key of this a h config
     */
    public String getPrimaryKey();

    /**
     * Sets the primary key of this a h config.
     *
     * @param primaryKey the primary key of this a h config
     */
    public void setPrimaryKey(String primaryKey);

    /**
     * Returns the name of this a h config.
     *
     * @return the name of this a h config
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this a h config.
     *
     * @param name the name of this a h config
     */
    public void setName(String name);

    /**
     * Returns the value of this a h config.
     *
     * @return the value of this a h config
     */
    @AutoEscape
    public String getValue();

    /**
     * Sets the value of this a h config.
     *
     * @param value the value of this a h config
     */
    public void setValue(String value);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(
        de.fraunhofer.fokus.oefit.particity.model.AHConfig ahConfig);

    @Override
    public int hashCode();

    @Override
    public CacheModel<de.fraunhofer.fokus.oefit.particity.model.AHConfig> toCacheModel();

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHConfig toEscapedModel();

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHConfig toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
