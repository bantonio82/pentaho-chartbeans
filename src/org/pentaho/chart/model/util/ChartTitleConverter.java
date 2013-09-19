/*!
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
* Foundation.
*
* You should have received a copy of the GNU Lesser General Public License along with this
* program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
* or from the Free Software Foundation, Inc.,
* 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
* See the GNU Lesser General Public License for more details.
*
* Copyright (c) 2002-2013 Pentaho Corporation..  All rights reserved.
*/

package org.pentaho.chart.model.util;

import org.pentaho.chart.model.ChartTitle;
import org.pentaho.chart.model.ChartTitle.TitleLocation;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ChartTitleConverter extends StyledTextConverter {

  public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
    ChartTitle chartTitle = (ChartTitle)value;
    if ((chartTitle.getText() != null) && (chartTitle.getText().length() > 0)) {
      if ((chartTitle.getLocation() != null) && (chartTitle.getLocation() != TitleLocation.TOP)) {
        writer.addAttribute("location", chartTitle.getLocation().toString());
      }
    }
    super.marshal(value, writer, context);
  }

  public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
    return null;
  }

  public boolean canConvert(Class clazz) {
    return clazz.equals(ChartTitle.class);
  }

}
