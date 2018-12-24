package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.pacing;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.enums.SimplifiedPacingTypeValues;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedPacing {


    private int number_of_iterations;

    private String type;

    private int delay;

    private int delay_random_range;

    public SimplifiedPacing() {
        this.number_of_iterations = 1;
        setType(SimplifiedPacingTypeValues.IMMEDIATELY.value());
    }

    public SimplifiedPacing(int number_of_iterations, String type, int delay, int delay_random_range) {
        this.number_of_iterations = number_of_iterations;
        setType(type);
        this.delay = delay;
        this.delay_random_range = delay_random_range;
    }

    public SimplifiedPacing(int number_of_iterations, SimplifiedPacingTypeValues type, int delay, int delay_random_range) {
        this.number_of_iterations = number_of_iterations;
        setType(type);
        this.delay = delay;
        this.delay_random_range = delay_random_range;
    }

    public void setType (String type) {
        this.type = type;
    }

    public void setType (SimplifiedPacingTypeValues type) {
        this.type = type.value();
    }

    @Override
    public String toString() {
        return "SimplifiedPacing {" +
                "number_of_iterations = " + number_of_iterations +
                ", " + "type = " + type +
                ", " + "delay = " + delay +
                ", " + "delay_random_range = " + delay_random_range +
                "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedPacing", SimplifiedPacing.class);
        xstream.aliasField("number_of_iterations", SimplifiedPacing.class, "number_of_iterations");
        xstream.aliasField("type", SimplifiedPacing.class, "type");
        xstream.aliasField("delay", SimplifiedPacing.class, "delay");
        xstream.aliasField("delay_random_range", SimplifiedPacing.class, "delay_random_range");
        xstream.aliasField("SimplifiedPacing", SimplifiedPacing.class, "SimplifiedPacing");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static SimplifiedPacing xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedPacing" , SimplifiedPacing.class);

        xstream.setClassLoader(SimplifiedPacing.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedPacing)xstream.fromXML(xml);
    }

}