//FULL ANSWER HERE -> https://stackoverflow.com/questions/45900523/connect-to-old-mysql-server-4-0-20-standard-from-php7

function select($params){
	$params = str_replace('\"',"'",$params);
	$params = str_replace('"',"'",$params);
	
	$plinkName = "plink.exe";//for security reasons change the name...
	$sshUser = "username";
	$sshPwd = "password";
	$sshDB = "databaseName";
	$sshIp = "192.168.1.1";
	$sshProtocol = "";//you can use -ssh
	$firstCommand = $plinkName." ".$sshProtocol." ".$sshIp." -l ".$sshUser." -pw ".$sshPwd;
	
	$comando = " ";
	$commands = array();
	
	$commands[0] = 'mysql -u root -e \"use '.$sshDB.'; '.$params.'\"';

	for($i=0;$i<count($commands); $i++){
		$comando .= $commands[$i];
		if($i+1<count($commands)){
			$comando .= "; ";
		}
	}
	
	$firstCommand = $firstCommand . $comando;
	//echo $firstCommand;//print the command to you DEBUG
		
	//Executing
	exec($firstCommand, $output, $flag);

	$colunas = array();
	$retorno = array();
	
	//Setar array de colunas
	if(count($output)>0){
		for($i=0;$i<count($output); $i++){
			if($i==0){
				$labels = $output[0];
				$labels = explode("	", $labels);
				for($j=0;$j<count($labels); $j++){
					$colunas[$j] = $labels[$j];
				}
			}
		}
		//setar estrutura do array e conteúdo
		for($i=0;$i<count($output) - 1; $i++){//index fix cause the first position of array (columns names)
			$linha = $labels = $output[$i + 1];
			$linha = explode("	", $linha);	//this is NOT a single space. it's like TAB
			
			$conteudo = array();
			
			for($j=0;$j<count($colunas); $j++){
				$vr = $linha[$j];
				if(trim($vr)==""){
					$vr = "NULL";//if result is blank, i change it to NULL
				}
				$retorno[$i][$colunas[$j]] = $vr;
			}
		}
	//print the array DEBUG
	//echo "<pre>";
	//print_r($retorno);
	//echo "</pre>";
		
		return $retorno;
	} else{
		return false;
	}
}

function insert($params){
	$params = str_replace('\"',"'",$params);
	$params = str_replace('"',"'",$params);
	
	$plinkName = "plink.exe";//for security reasons change the name...
	$sshUser = "username";
	$sshPwd = "password";
	$sshDB = "databaseName";
	$sshIp = "192.168.1.1";
	$sshProtocol = "";//you can use -ssh
	$firstCommand = $plinkName." ".$sshProtocol." ".$sshIp." -l ".$sshUser." -pw ".$sshPwd;
	
	$comando = " ";
	$commands = array();
	
	$commands[0] = 'mysql -u root -e \"use '.$sshDB.'; '.$params.'\"';

	for($i=0;$i<count($commands); $i++){
		$comando .= $commands[$i];
		if($i+1<count($commands)){
			$comando .= "; ";
		}
	}
	
	$firstCommand = $firstCommand . $comando;
	//echo $firstCommand;//print the command to you DEBUG
		
	//Executing
	exec($firstCommand, $output, $flag);
	
	if($flag==0){
		return true;
	} else {
		return false;
	}
}
