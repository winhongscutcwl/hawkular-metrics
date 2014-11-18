package org.rhq.metrics.core;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

/**
 * @author John Sanda
 */
public class Metric {

    private String tenantId;

    private MetricId id;

    private Map<String, String> attributes = new HashMap<>();

    private long dpart;

    public String getTenantId() {
        return tenantId;
    }

    public Metric setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public MetricId getId() {
        return id;
    }

    public Metric setId(MetricId id) {
        this.id = id;
        return this;
    }

    public long getDpart() {
        return dpart;
    }

    public Metric setDpart(long dpart) {
        this.dpart = dpart;
        return this;
    }

    /**
     * A set of key/value pairs that are shared by all data points for the metric. A good example is units like KB / sec.
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

    public Metric setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Stores an attribute which will be shared by all data points for the metric when it is persisted. If an attribute
     * with the same name already exists, it will be overwritten.
     *
     * @param name The attribute name.
     * @param value The attribute value
     */
    public Metric setAttribute(String name, String value) {
        attributes.put(name, value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Metric metric = (Metric) o;

        if (dpart != metric.dpart) return false;
        if (attributes != null ? !attributes.equals(metric.attributes) : metric.attributes != null) return false;
        if (!id.equals(metric.id)) return false;
        if (!tenantId.equals(metric.tenantId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tenantId.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result + (int) (dpart ^ (dpart >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("tenantId", tenantId)
            .add("id", id)
            .add("attributes", attributes)
            .add("dpart", dpart)
            .toString();
    }
}
