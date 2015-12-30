/*
 * The MIT License
 *
 * Copyright 2015 M.D.Ward <matthew.ward@byng.co>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.configfiles.properties;

import hudson.Extension;
import org.jenkinsci.lib.configprovider.AbstractConfigProviderImpl;
import org.jenkinsci.lib.configprovider.model.Config;
import org.jenkinsci.lib.configprovider.model.ContentType;
import org.jenkinsci.plugins.configfiles.Messages;

/**
 * PropertiesConfig
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 * @copyright (c) 2015, Byng Services Ltd
 */
public class PropertiesConfig extends Config {

    public PropertiesConfig(String id, String name, String comment, String content) {
        super(id, name, comment, content);
    }
    
    @Extension(ordinal = 160)
    public static class PropertiesConfigProvider extends AbstractConfigProviderImpl {

        public PropertiesConfigProvider() {
            load();
        }

        @Override
        public ContentType getContentType() {
            return new ContentType() {

                @Override
                public String getCmMode() {
                    return "properties";
                }

                @Override
                public String getMime() {
                    return "text/x-ini";
                }
            };
        }

        @Override
        public String getDisplayName() {
            return Messages.properties_provider_name();
        }

        @Override
        public Config newConfig() {
            return new Config(super.newConfig().id, "file.properties", "Properties file", "[header]\nname = value", getProviderId());
        }
        
    }
    
}
