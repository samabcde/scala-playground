import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.{XSSFChart, XSSFWorkbook}
import org.apache.poi.xddf.usermodel.chart.*

object GenerateGraph {
  def main(args: Array[String]): Unit = {
    createExcelChart(data, "chart.xlsx")
  }

  def createExcelChart(data: Seq[(Double, Double)], outputPath: String): Unit = {
    val workbook = new XSSFWorkbook()
    val sheet = workbook.createSheet("Data")

    // Create headers
    val headerRow = sheet.createRow(0)
    headerRow.createCell(0).setCellValue("Improve")
    headerRow.createCell(1).setCellValue("Profit")

    // Add data
    data.zipWithIndex.foreach { case ((improve, profit), index) =>
      val row = sheet.createRow(index + 1)
      row.createCell(0).setCellValue(improve)
      row.createCell(1).setCellValue(profit)
    }

    // Create drawing and chart
    val drawing = sheet.createDrawingPatriarch()
    val anchor = drawing.createAnchor(0, 0, 0, 0, 4, 0, 15, 20)
    val chart = drawing.createChart(anchor).asInstanceOf[XSSFChart]

    // Create axis
    val bottomAxis = chart.createValueAxis(AxisPosition.BOTTOM)
    val leftAxis = chart.createValueAxis(AxisPosition.LEFT)

    // Create data sources
    val improveRange = new CellRangeAddress(1, data.size, 0, 0)
    val profitRange = new CellRangeAddress(1, data.size, 1, 1)

    val improveData = XDDFDataSourcesFactory.fromNumericCellRange(sheet, improveRange)
    val profitData = XDDFDataSourcesFactory.fromNumericCellRange(sheet, profitRange)

    // Create chart data
    val chartData = chart.createData(ChartTypes.LINE, bottomAxis, leftAxis)
    chartData.asInstanceOf[XDDFLineChartData]

    // Add series
    val series = chartData.addSeries(improveData, profitData)
    series.setTitle("Profit vs Improve", null)

    // Plot the chart
    chart.plot(chartData)

    // Save workbook
    val fileOut = new java.io.FileOutputStream(outputPath)
    workbook.write(fileOut)
    fileOut.close()
    workbook.close()
  }

  // Example usage
  val data = Seq(
    (1.0, 100.0),
    (2.0, 150.0),
    (3.0, 200.0),
    (4.0, 250.0),
    (5.0, 350.0),
    (6.0, 450.0),
    (7.0, 150.0),
    (8.0, -250.0),
    (9.0, -350.0),
  )


}
