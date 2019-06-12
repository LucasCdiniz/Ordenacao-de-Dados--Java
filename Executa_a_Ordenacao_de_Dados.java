// Criado e Desenvolivdo por:
// Lucas Celestino Diniz
// lucascelestino.diniz@gmail.com

/*
    Programa que realiza a Ordenação de Dados utilizandos as ordenações:
    BubbleSort;SelectionSort;InsertionSort;QuickSort;MergeSort
    Com a possibilidade de informar dez (10) números para realizar a Ordenação que desejar
    Assim como há a possibilidade de gerar estes números aleatóriamente
    Tratamento de erro realizado para que o usuário digite apenas números e nenhuma letra
    Tratamento de erro realizado também para que o usuário não prossiga ao deixar a opção em branco
    Tratamento de erro para que o cliente digite apenas os números que estão dispostos no formulário
*/


package ordenacaodedados; // PACOTE ORDENACAODEDADOS

// IMPORTAÇÕES
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Executa_a_Ordenacao_de_Dados { 

    
// INÍCIO DA CLASSE
    
    // DECLARAÇÕES DE VARIÁVEIS
    private String menu, opcao;
    private int i,j,aux;
    private long tempoInicial, tempoFinal; // <- VARIÁVEIS PARA UTILIZAR NO DESCOBRIMENTO DO TEMPO DE EXECUÇÃO
    private int vet[] = new int[10];
    private int w[] = new int[vet.length]; // VETOR UTILIZADO NO MÉTODO MERGESORT
    
    // MÉTODO EXECUTA_A_ORDENACAO QUE COMEÇA O PROGRAMA
    public void Executa_a_Ordenacao() { 
		Inserir(); // FAZ A CHAMADA DO MÉTODO INSERIR
	} // FIM DO MÉTODO EXECUTA_A_ORDENACAO
    
    // INÍCIO DO MÉTODO INSERIR
    private void Inserir(){ 
         try{ // TRY
             
             /*PRIMEIRA TELA PARA O USUÁRIO ESCOLHER ENTRE 
             INSERIR VALORES MANUALMENTE OU GERAR ELES ALEATÓRIAMENTE*/
                opcao = JOptionPane.showInputDialog(null, 
                "Escolha uma Opção:\n\n"
                     +"1 - Inserir valores manualmente.\n"
                        +"2 - Gerar números aleatórios.\n"
                            , "Inserção de Valores", 1);
                 // WHILE PARA NÃO DEIXAR O ESPAÇO EM BRANCO E NEM PRA SER DIGITADO NADA DIFERENTE DE 1 E 2            
                 while(opcao.isEmpty() || Integer.parseInt(opcao)!=1 && Integer.parseInt(opcao)!=2){ 
                    
                     // TELA QUANDO ACONTECE ALGUM ERRO
                     JOptionPane.showMessageDialog(null, "Digete novamente.", "Atenção", 0);
                     
                     /*PRIMEIRA TELA PARA O USUÁRIO ESCOLHER ENTRE 
             INSERIR VALORES MANUALMENTE OU GERAR ELES ALEATÓRIAMENTE*/
                    opcao = JOptionPane.showInputDialog(null, 
                         "Escolha uma Opção:\n\n"
                             +"1 - Inserir valores manualmente.\n"
                                 +"2 - Gerar números aleatórios.\n"
                                     , "Inserção de Valores", 1);
        } // FIM WHILE
         }catch(NumberFormatException e){ // CATCH PARA SER DIGITADO APENAS NÚMEROS
             
           // TELA QUANDO ACONTECE ALGUM ERRO
           JOptionPane.showMessageDialog(null, "Digite apenas números", "Atenção", 0);
           
           /*PRIMEIRA TELA PARA O USUÁRIO ESCOLHER ENTRE 
             INSERIR VALORES MANUALMENTE OU GERAR ELES ALEATÓRIAMENTE*/
                opcao = JOptionPane.showInputDialog(null, 
                "Escolha uma Opção:\n\n"
                    +"1 - Inserir valores manualmente.\n"
                        +"2 - Gerar números aleatórios.\n"
                            , "Inserção de Valores", 1);
                // WHILE PARA NÃO DEIXAR O ESPAÇO EM BRANCO E NEM PRA SER DIGITADO NADA DIFERENTE DE 1 E 2 
                 while(opcao.isEmpty() || Integer.parseInt(opcao)!=1 && Integer.parseInt(opcao)!=2){  
                    
                     // TELA QUANDO ACONTECE ALGUM ERRO
                     JOptionPane.showMessageDialog(null, "Digete novamente.", "Atenção", 0);
                    opcao = JOptionPane.showInputDialog(null, 
                         "Escolha uma Opção:\n\n"
                            +"1 - Inserir valores manualmente.\n"
                                +"2 - Gerar números aleatórios.\n"
                                    , "Inserção de Valores", 1);}
                
                } // FIM WHILE
       // INÍCIO SWITCH - INSERIR
       switch(Integer.parseInt(opcao)){  
                case(1): InserirValor();
                break;
                case(2): Random();
                break;
            } // FIM SWITCH - INSERIR
       
       MenuPrincipal(); // CHAMADA DO MÉTODO MENUPRINCIPAL 
       
    } // FIM DO MÉTODO INSERIR
    
    // MÉTODO - INSERIRVALOR
    private void InserirValor(){ 
        for(i=0;i<(vet.length);i++){ // INÍCIO FOR
           aux = i + 1;
           vet[i] = Integer.parseInt(JOptionPane.showInputDialog(
                   "insira o "+aux+"º valor"));
        } // FIM FOR
        
        // APRESENTA NA TELA OS NÚMEROS QUE O USUÁRIO INSERIU
        JOptionPane.showMessageDialog(null,"Os valores são: ["
        +vet[0]+","+vet[1]+","+vet[2]+","+vet[3]+","+vet[4]+","+vet[5]
                +","+vet[6]+","+vet[7]+","+vet[8]+","+vet[9]+"]","Inseridos Manualmente",1);   
        MenuPrincipal(); // CHAMADA DO MÉTODO MENUPRINCIPAL 
    } // FIM DO  MÉTODO INSERIRVALOR
    
    // INÍCIO DO MÉTODO RANDOM
    private void Random(){ 
        long aux2 = 0;
        for(i=0;i<(vet.length)-1;i++){ //INÍCIO FOR
            aux2= Math.round(Math.random()*100);
            vet[i] =(int) aux2;
        }// FIM FOR
        
        // APRESENTA NA TELA A ORDENAÇÃO DOS NÚMEROS ALEATÓRIOS 
        JOptionPane.showMessageDialog(null,"Os valores são: ["
        +vet[0]+","+vet[1]+","+vet[2]+","+vet[3]+","+vet[4]+","+vet[5]
                +","+vet[6]+","+vet[7]+","+vet[8]+","+vet[9]+"]","Inseridos Aleatóriamente",1);
        MenuPrincipal(); // CHAMADA DO MÉTODO MENUPRINCIPAL 
    } //FIM DO MÉTODO RANDOM
    
    // INÍCIO DO MÉTODO MENUPRINCIPAL
    private void MenuPrincipal(){ 
       try{ // TRY
           
        // TELA DO MENU PRINCIPAL
        menu = JOptionPane.showInputDialog(null, 
                "Escolha uma opção:\n\n"
            
            +"1 - BubbleSort.\n"
            +"2 - SelectionSort.\n"
            +"3 - InsertionSort.\n"
            +"4 - QuickSort.\n"
            +"5 - MergeSort.\n"
            +"6 - Inserir novos valores manualmente.\n"
            +"7 - Gerar novos números aleatórios.\n"
            +"9 - Sair.", "Menu Principal", 1);
        
        //WHILE PARA QUE NÃO SEJE DIFERENTE DE 1 E 2 NEM QUE FIQUE EM BRANCO
        while(menu.isEmpty() || Integer.parseInt(menu)!=1 && Integer.parseInt(menu)!=2 
               && Integer.parseInt(menu)!=3 && Integer.parseInt(menu)!=4 && Integer.parseInt(menu)!=5
                    && Integer.parseInt(menu)!=6 && Integer.parseInt(menu)!=7 
                        && Integer.parseInt(menu)!=9 ){
            // TELA QUANDO ACONTECE ALGUM ERRO
            
            JOptionPane.showMessageDialog(null, "Digite novamente", "Atenção", 0);
            
            // TELA DO MENU PRINCIPAL
            menu = JOptionPane.showInputDialog(null, 
                "Escolha uma opção:\n\n"
            
            +"1 - BubbleSort.\n"
            +"2 - SelectionSort.\n"
            +"3 - InsertionSort.\n"
            +"4 - QuickSort.\n"
            +"5 - MergeSort.\n"
            +"6 - Inserir novos valores manualmente.\n"
            +"7 - Gerar novos números aleatórios.\n"
            +"9 - Sair.", "Menu Principal", 1);
        }
            }catch(NumberFormatException e){ // CATCH PARA SER DIGITADO APENAS NÚMEROS
                // TELA QUANDO ACONTECE ALGUM ERRO
                JOptionPane.showMessageDialog(null, "Digite apenas números", "Atenção", 0);
                
                // TELA DO MENU PRINCIPAL
                menu = JOptionPane.showInputDialog(null, 
                "Escolha uma opção:\n\n"
            
            +"1 - BubbleSort.\n"
            +"2 - SelectionSort.\n"
            +"3 - InsertionSort.\n"
            +"4 - QuickSort.\n"
            +"5 - MergeSort.\n"
            +"6 - Inserir novos valores manualmente.\n"
            +"7 - Gerar novos números aleatórios.\n"
            +"9 - Sair.", "Menu Principal", 1);
                
                /* WHILE PARA NÃO DEIXAR A RESPOSTA EM BRANCO 
                    NEM DIFERENTE DE 1,2,3,4,5,6,7 E 9*/
                
               while(menu.isEmpty() || Integer.parseInt(menu)!=1 && Integer.parseInt(menu)!=2
               && Integer.parseInt(menu)!=3 && Integer.parseInt(menu)!=4 && Integer.parseInt(menu)!=5
                    && Integer.parseInt(menu)!=6 && Integer.parseInt(menu)!=7 
                       && Integer.parseInt(menu)!=9 ){
            // TELA QUANDO ACONTECE ALGUM ERRO
            JOptionPane.showMessageDialog(null, "Digite novamente", "Atenção", 0);
                
            // TELA DO MENU PRINCIPAL
            menu = JOptionPane.showInputDialog(null, 
                "Escolha uma opção:\n\n"
            
            +"1 - BubbleSort.\n"
            +"2 - SelectionSort.\n"
            +"3 - InsertionSort.\n"
            +"4 - QuickSort.\n"
            +"5 - MergeSort.\n"
            +"6 - Inserir novos valores manualmente.\n"
            +"7 - Gerar novos números aleatórios.\n"
            +"9 - Sair.", "Menu Principal", 1);
        }
       }
        
        switch(Integer.parseInt(menu)){ // SWITCH PARA A ESCOLHA E EXECUÇÃO DOS MÉTODOS QUE USUÁRIO DESEJAR
                case(1): tempoInicial = System.currentTimeMillis(); // PEGA O TEMPO INICIAL
                         BubbleSort(); // EXECUTA O MÉTODO
                         tempoFinal = System.currentTimeMillis()- tempoInicial; // PEGA O TEMPO FINAL
                         JOptionPane.showMessageDialog(null, "Executado em "+(tempoFinal/1000) + " segundos","Tempo de Execução",1); // APRESENTA QUANTOS MILESSEGUNDOS DEMOROU PARA SER EXECUTADO O MÉTODO
                         MenuPrincipal(); // FAZ A CHAMADA DO MÉTODO PARA VOLTAR AO MENU PRINCIPAL
                break;
                
                case(2): tempoInicial = System.currentTimeMillis(); // PEGA O TEMPO INICIAL
                         SelectionSort(); // EXECUTA O MÉTODO
                         tempoFinal = System.currentTimeMillis() - tempoInicial; // PEGA O TEMPO FINAL
                         JOptionPane.showMessageDialog(null, "Executado em "+ (tempoFinal/1000)  + " segundos","Tempo de Execução",1); // APRESENTA QUANTOS MILESSEGUNDOS DEMOROU PARA SER EXECUTADO O MÉTODO
                         MenuPrincipal(); // FAZ A CHAMADA DO MÉTODO PARA VOLTAR AO MENU PRINCIPAL
                break;
                
                case(3): tempoInicial = System.currentTimeMillis(); // PEGA O TEMPO INICIAL
                         InsertionSort(); // EXECUTA O MÉTODO
                         tempoFinal = System.currentTimeMillis()- tempoInicial; // PEGA O TEMPO FINAL
                         JOptionPane.showMessageDialog(null, "Executado em "+(tempoFinal/1000) + " segundos","Tempo de Execução",1); // APRESENTA QUANTOS MILESSEGUNDOS DEMOROU PARA SER EXECUTADO O MÉTODO
                         MenuPrincipal(); // FAZ A CHAMADA DO MÉTODO PARA VOLTAR AO MENU PRINCIPAL
                break;
                
                case(4): tempoInicial = System.currentTimeMillis(); // PEGA O TEMPO INICIAL
                         quickSort(vet,0,vet.length-1); // EXECUTA O MÉTODO
                         JOptionPane.showMessageDialog(null, Arrays.toString(vet), "QuickSort",1); // APRESENTA O RESULTADO DA ORDENAÇÃO
                         tempoFinal = System.currentTimeMillis()- tempoInicial; // PEGA O TEMPO FINAL
                         JOptionPane.showMessageDialog(null, "Executado em "+(tempoFinal/1000) + " segundos","Tempo de Execução",1); // APRESENTA QUANTOS MILESSEGUNDOS DEMOROU PARA SER EXECUTADO O MÉTODO
                         MenuPrincipal(); // FAZ A CHAMADA DO MÉTODO PARA VOLTAR AO MENU PRINCIPAL
                break;
                
                case(5):tempoInicial = System.currentTimeMillis(); // PEGA O TEMPO INICIAL
                        mergeSort(vet, w, 0, vet.length-1); // EXECUTA O MÉTODO
                        JOptionPane.showMessageDialog(null, Arrays.toString(vet), "MergeSort",1); // APRESENTA O RESULTADO DA ORDENAÇÃO
                        tempoFinal = System.currentTimeMillis()- tempoInicial; // PEGA O TEMPO FINAL
                         JOptionPane.showMessageDialog(null, "Executado em "+(tempoFinal/1000) + " segundos","Tempo de Execução",1); // APRESENTA QUANTOS MILESSEGUNDOS DEMOROU PARA SER EXECUTADO O MÉTODO
                        MenuPrincipal(); // FAZ A CHAMADA DO MÉTODO PARA VOLTAR AO MENU PRINCIPAL
                break;
                
                case(6): InserirValor(); // EXECUTA O MÉTODO
                break;
                case(7): Random(); // EXECUTA O MÉTODO
                break;
                case(9): System.exit(0); // SAIR DO PROGRAMA - FECHA O PROGRAMA
                break;
            } // FIM SWITCH
        
    } // FIM DO METODO MENUPRINCIPAL
    
     //************************************************************************
    //********************DECLARAÇÃO DE TODOS OS MÉTODOS***********************
    //***********************PARA A ORDENAÇÃO DE DADOS*************************
    //*************************************************************************
    
    // MÉTODO BUBBLESORT
     public void BubbleSort(){ 
        for(i=0;i<(vet.length);i++){ //INÍCIO FOR - i
            for(j=i+1;j<(vet.length);j++){ // INÍCIO FOR - j
                
                if(vet[i]>vet[j]){ // INÍCIO IF
                    aux = vet[i];
                    vet[i] = vet[j];
                    vet[j] = aux;
                } // FIM IF
                
            } // FIM FOR - j
            
        } // FIM FOR - i
        
         // APRESENTA O RESULTADO DA ORDENAÇÃO
        JOptionPane.showMessageDialog(null,"["
                +vet[0]+","+vet[1]+","+vet[2]+","+vet[3]+","+vet[4]+","+vet[5]
                +","+vet[6]+","+vet[7]+","+vet[8]+","+vet[9]+"]","BubbleSort",1); 
        
    } //FIM BUBBLESORT
     
     // INÍCIO SELECTIONSORT
        public void SelectionSort(){ 
        for(i=0;i<(vet.length);i++){ //INÍCIO FOR - i
            for(j=i+1;j<(vet.length);j++){ // INÍCIO FOR - j
                
                if(vet[i]<vet[j]){ // INÍCIO IF
                    aux = vet[i];
                    vet[i] = vet[j];
                    vet[j] = aux;
                } // FIM IF
                
            } // FIM FOR - j
            
        } // INÍCIO FOR - i
        
         // APRESENTA O RESULTADO DA ORDENAÇÃO
        JOptionPane.showMessageDialog(null,"["
                +vet[0]+","+vet[1]+","+vet[2]+","+vet[3]+","+vet[4]+","+vet[5]
                +","+vet[6]+","+vet[7]+","+vet[8]+","+vet[9]+"]","SelectionSort",1);
        
        
    } // FIM DO MÉTODO SELECTIONSORT
     
      // INÍCIO MÉTODO INSERTIONSORT
       public void InsertionSort(){ 
               
        for(i=1;i<(vet.length);i++){
            aux=vet[i];
            j= i - 1;
            while((j>=0) && vet[j] > aux){
                vet[j+1] = vet[j];
                j =j-1;
            }
            vet[j+1]=aux;
        }
        
                 // APRESENTA O RESULTADO DA ORDENAÇÃO
                JOptionPane.showMessageDialog(null,"["
                +vet[0]+","+vet[1]+","+vet[2]+","+vet[3]+","+vet[4]+","+vet[5]
                +","+vet[6]+","+vet[7]+","+vet[8]+","+vet[9]+"]", "InsertionSort", 1);
                
    } // FIM MÉTODO INSERTION SORT 
       
       
    // INÍCIO MÉTODO QUICKSORT
    private void quickSort(int[]vet,int esq,int dir){
        if(esq<dir){
               int j = separar(vet,esq,dir);
                quickSort(vet, esq, j-1);
                quickSort(vet, j+1, dir);
        }
        
    } // FIM MÉTODO QUICKSORT
      
    // INÍCIO MÉTODO SEPARAR - QUICKSORT
      private int separar(int[] vet, int esq, int dir) { 
        int i = esq +1;
         int j = dir;
        int pivo = vet[esq]; // PIVÔ 
        while(i <= j){
            if(vet[i] <= pivo)i++;
            else if(vet[j] > pivo) j--;
            else if(i<=j){
                trocar(vet,i,j);
                i++;
                j--;
            }
        }
        trocar(vet,esq,j);
        return j;
    } // FIM MÉTODO SEPARAR - QUICKSORT
      
      // INÍCIO MÉTODO TROCAR - QUICKSORT
       private void trocar(int[] vet, int i, int j){ 
        
        aux =vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
        
    } // FIM MÉTODO TROCAR - QUICKSORT
       
      // INÍCIO DO MÉTODO MERGESORT
      private static void mergeSort(int vet [], int [] w, int ini, int fim){
            if(ini<fim){
                int meio = (ini+fim)/2; // DIVIDIR PARA CONQUISTAR
                mergeSort(vet, w, ini, meio);
                mergeSort(vet, w, meio+1, fim);
                intercalar(vet, w, ini, meio, fim);
            }
            
      } // FIM DO MÉTODO MERGESORT
      
      // INÍCIO DO MÉTODO INTERCALAR - MERGESORT
      private static void intercalar(int[] vet, int[] w, int ini, int meio, int fim) {
        for(int k = ini;k<=fim;k++)
            
            w[k] = vet[k];
            int i = ini;
            int j = meio+1;
            
            for(int k = ini;k<=fim;k++){
                if(i>meio) vet[k] = w[j++];
                else if (j>fim) vet[k] = w[i++];
                else if (w[i]<w[j]) vet[k] = w[i++];
                else vet[k] = w[j++];
            }
        
    } // FIM DO MÉTODO INTERCALAR - MERGESORT
      
     //************************************************************************
    //******************FIM DAS DECLARAÇÕES DE TODOS OS MÉTODOS****************
    //*************************************************************************
    //*************************************************************************
       
} // FIM DA CLASSE EXECUTA_A_ORDECAO_DE_DADOS


// Criado e Desenvolivdo por:
// Lucas Celestino Diniz
// lucascelestino.diniz@gmail.com