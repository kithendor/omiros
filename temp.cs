using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO.Ports;
using System.IO;
using System.Reflection;

namespace map2
{
    public partial class Form1 : Form
    {
        private SerialPort myport;
        string keimeno;

        public Form1()
        {
            InitializeComponent();
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            myport = new SerialPort();
            myport.BaudRate = 9600;
            myport.PortName = textBox1.Text;
            myport.Parity = Parity.None;
            myport.DataBits = 8;
            myport.StopBits = StopBits.One;
            myport.DataReceived += myport_DataReceived;
            try
            {
                myport.Open();

            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "zimia");
            }
        }
        private void myport_DataReceived(object sender, SerialDataReceivedEventArgs e)
        {

            this.Invoke(new EventHandler(dispaydata_event));

        }
        private void dispaydata_event(object sender, EventArgs e)
        {
            keimeno = myport.ReadLine();
            if (keimeno.Contains("a"))
            {
                label1.Text = "ENA";
                //var bmp = new Bitmap(ardu.Properties.Resources.d__1_);
                //label2.Image = bmp;
            }
            if (keimeno.Contains("b"))
            {
               label1.Text = "DUIO";
                //var bmp = new Bitmap(ardu.Properties.Resources.d__2_);
                //label2.Image = bmp;
            }
            if (keimeno.Contains("t"))
            {
                //var bmp = new Bitmap(ardu.Properties.Resources.i);
                //label2.Image = bmp;
                //label1.Text = "TRIA";
            }
            if (keimeno.Contains("n"))
            {
                //label2.Text = "";
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
