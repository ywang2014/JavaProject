package com.test.model.json;

public enum Include {
	/**
     * Value that indicates that property is to be always included,
     * independent of value of the property.
     */
    ALWAYS,

    /**
     * Value that indicates that only properties with non-null
     * values are to be included.
     */
    NON_NULL,

    /**
     * Value that indicates that properties are included unless their value
     * is:
     *<ul>
     *  <li>null</li>
     *  <li>"absent" value of a referential type (like Java 8 `Optional`, or
     *     {link java.utl.concurrent.atomic.AtomicReference}); that is, something
     *     that would not deference to a non-null value.
     * </ul>
     * This option is mostly used to work with "Optional"s (Java 8, Guava).
     *
     * @since 2.6
     */
    NON_ABSENT,

    /**
     * Value that indicates that only properties with null value,
     * or what is considered empty, are not to be included.
     * Definition of emptiness is data type specific; see below
     * for details on actual handling.
     *<p>
     * Default emptiness for all types includes:
     *<ul>
     * <li><code>Null</code> values.</li>
     * <li>"Absent" values (see {@link #NON_ABSENT})</li>
     *</ul>
     * so that as baseline, "empty" set includes values that would be
     * excluded by both {@link #NON_NULL} and {@link #NON_ABSENT}.
     *<br>
     * Beyond this base, following types have additional empty values:
     *<ul>
     * <li>For {@link java.util.Collection}s and {@link java.util.Map}s,
     *    method <code>isEmpty()</code> is called;
     *   </li>
     * <li>For Java arrays, empty arrays are ones with length of 0
     *   </li>
     * <li>For Java {@link java.lang.String}s, <code>length()</code> is called,
     *   and return value of 0 indicates empty String
     *   </li>
     * </ul>
     *  and for other types, null values are excluded but other exclusions (if any).
     *<p>
     * Note that this default handling can be overridden by custom
     * <code>JsonSerializer</code> implementation: if method <code>isEmpty()</code>
     * is overridden, it will be called to see if non-null values are
     * considered empty (null is always considered empty).
     *<p>
     * Compatibility note: Jackson 2.6 included a wider range of "empty" values than
     * either earlier (up to 2.5) or later (2.7 and beyond) types; specifically:
     *<ul>
     * <li>Default values of primitive types (like <code>0</code> for `int`/`java.lang.Integer`
     *  and `false` for `bool`/`Boolean`)
     *  </li>
     * <li>Timestamp 0 for date/time types
     *  </li>
     *</ul>
     * With 2.7, definition has been tightened back to only containing types explained
     * above (null, absent, empty String, empty containers), and now
     * extended definition may be specified using {@link #NON_DEFAULT}.
     */
    NON_EMPTY,

    /**
     * Meaning of this setting depends on context: whether annotation is
     * specified for POJO type (class), or not. In latter case annotation
     * is either used as the global default, or as property override.
     *<p>
     * When used for a POJO, definition is that only values that differ from
     * the default values of POJO properties are included. This is done
     * by creating an instance of POJO using zero-argument constructor,
     * and accessing property values: value is used as the default value
     * by using <code>equals()</code> method, except for the case where property
     * has `null` value in which straight null check is used.
     *<p>
     * When NOT used for a POJO (that is, as a global default, or as property
     * override), definition is such that:
     *<ul>
     * <li>All values considered "empty" (as per {@link #NON_EMPTY}) are excluded</li>
     * <li>Primitive/wrapper default values are excluded</li>
     * <li>Date/time values that have timestamp (`long` value of milliseconds since
     *   epoch, see {@link java.util.Date}) of `0L` are excluded</li>
     * </ul>
     */
    NON_DEFAULT,
    
    /**
     * Pseudo-value used to indicate that the higher-level defaults make
     * sense, to avoid overriding inclusion value. For example, if returned
     * for a property this would use defaults for the class that contains
     * property, if any defined; and if none defined for that, then 
     * global serialization inclusion details.
     *
     * @since 2.6
     */
    USE_DEFAULTS
    
    ;
}
