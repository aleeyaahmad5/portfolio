USE [master]
GO

/****** Object:  Database [DB_project_stage1_ElectroWorld]    Script Date: 13/09/2024 2:19:52 AM ******/
CREATE DATABASE [DB_project_stage1_ElectroWorld]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DB_project_stage1_ElectroWorld', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER2019\MSSQL\DATA\DB_project_stage1_ElectroWorld.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DB_project_stage1_ElectroWorld_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER2019\MSSQL\DATA\DB_project_stage1_ElectroWorld_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DB_project_stage1_ElectroWorld].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET ARITHABORT OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET  DISABLE_BROKER 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET RECOVERY FULL 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET  MULTI_USER 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET DB_CHAINING OFF 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET QUERY_STORE = OFF
GO

ALTER DATABASE [DB_project_stage1_ElectroWorld] SET  READ_WRITE 
GO

